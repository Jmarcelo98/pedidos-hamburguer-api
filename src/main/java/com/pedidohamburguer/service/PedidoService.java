package com.pedidohamburguer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.dto.PedidoDTO;
import com.pedidohamburguer.model.entity.Carne;
import com.pedidohamburguer.model.entity.Molho;
import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.model.entity.Usuario;
import com.pedidohamburguer.repository.MolhoRepository;
import com.pedidohamburguer.repository.PedidoRepository;
import com.pedidohamburguer.repository.UsuarioRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MolhoRepository molhoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	public ResponseEntity<Integer> adicionarPedido(PedidoDTO pedidoDTO) {

		Usuario usuarioPedido = usuarioService.pesquisarPeloNomeESobrenome(pedidoDTO.getUsuarioDTO().getNome(),
				pedidoDTO.getUsuarioDTO().getSobrenome());

		if (usuarioPedido == null) {
			usuarioPedido.setNome(pedidoDTO.getUsuarioDTO().getNome());
			usuarioPedido.setSobrenome(pedidoDTO.getUsuarioDTO().getSobrenome());
			usuarioPedido.setAdmin(pedidoDTO.getUsuarioDTO().getAdmin());
			usuarioPedido.setSenha(null);
			usuarioPedido.setId(null);
			usuarioRepository.save(usuarioPedido);
		}

		List<String> molhosSelecionados = new ArrayList<>();

		List<Molho> molhos = new ArrayList<>();

		if (pedidoDTO.getMolhoDTO().size() > 0) {

			for (int i = 0; i < pedidoDTO.getMolhoDTO().size(); i++) {
				molhosSelecionados.add(pedidoDTO.getMolhoDTO().get(i).getNomeMolho());
			}

			molhos = molhoRepository.findByNomeMolhoIn(molhosSelecionados);

		} else {
			molhos = Collections.emptyList();
		}

		Pedido pedido = new Pedido(null, usuarioPedido,
				new Pao(pedidoDTO.getPaoDTO().getId(), pedidoDTO.getPaoDTO().getNome()),
				new Carne(pedidoDTO.getCarneDTO().getId(), pedidoDTO.getCarneDTO().getPontoCarne()),
				pedidoDTO.getQueijo(), pedidoDTO.getAlface(), pedidoDTO.getTomate(), pedidoDTO.getBacon(),
				pedidoDTO.getCebolaCaramelizada(), new Date(), pedidoDTO.getConcluido(), molhos);

		pedidoRepository.save(pedido);
		return ResponseEntity.ok().body(pedido.getId());
	}

	public ResponseEntity<List<PedidoDTO>> buscarPedidosEmEspera() {

		List<Pedido> list = pedidoRepository.findByConcluidoOrderByDataCriacaoAsc(false);
		List<PedidoDTO> listDTO = list.stream().map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	public void finalizarPedido(Integer idPedido) {

		Optional<Pedido> pedidoAtt = pedidoRepository.findById(idPedido);
		if (!pedidoAtt.isEmpty()) {
			pedidoAtt.get().setConcluido(true);
			pedidoRepository.save(pedidoAtt.get());
		}

	}

}
