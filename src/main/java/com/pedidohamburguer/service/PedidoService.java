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

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MolhoRepository molhoRepository;

	@Autowired
	private CarneService carneService;

	@Autowired
	private PaoService paoService;

	public ResponseEntity<Integer> adicionarPedido(PedidoDTO pedidoDTO) {

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

		Carne carneSelecionada = carneService.buscarPeloPontoDaCarne(pedidoDTO.getCarneDTO().getPontoCarne());

		Pao paoSelecionado = paoService.buscarPaoPeloNome(pedidoDTO.getPaoDTO().getNome());

		Pedido pedido = new Pedido(null,
				new Usuario(pedidoDTO.getUsuarioDTO().getId(), pedidoDTO.getUsuarioDTO().getNome(),
						pedidoDTO.getUsuarioDTO().getSobrenome(), null, false),
				paoSelecionado, carneSelecionada, pedidoDTO.getQueijo(), pedidoDTO.getAlface(), pedidoDTO.getTomate(),
				pedidoDTO.getBacon(), pedidoDTO.getCebolaCaramelizada(), new Date(), pedidoDTO.getConcluido(), molhos);

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
