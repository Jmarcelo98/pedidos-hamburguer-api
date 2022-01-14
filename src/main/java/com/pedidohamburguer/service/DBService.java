package com.pedidohamburguer.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pedidohamburguer.model.entity.Carne;
import com.pedidohamburguer.model.entity.Molho;
import com.pedidohamburguer.model.entity.Pao;
import com.pedidohamburguer.model.entity.Pedido;
import com.pedidohamburguer.model.entity.Usuario;
import com.pedidohamburguer.model.enums.CarneEnum;
import com.pedidohamburguer.model.enums.MolhoEnum;
import com.pedidohamburguer.model.enums.PaoEnum;
import com.pedidohamburguer.repository.CarneRepository;
import com.pedidohamburguer.repository.MolhoRepository;
import com.pedidohamburguer.repository.PaoRepository;
import com.pedidohamburguer.repository.PedidoRepository;
import com.pedidohamburguer.repository.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CarneRepository carneRepository;

	@Autowired
	private PaoRepository paoRepository;

	@Autowired
	private MolhoRepository molhoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public void instaciarBancoDeDadosH2() {

		Calendar data = Calendar.getInstance();

		Usuario usuario = new Usuario(null, "ADMIN", null, bCryptPasswordEncoder.encode("admin123"), true);
		Usuario usuario1 = new Usuario(null, "JOAO", "MARCELO", null, false);

		usuarioRepository.saveAll(Arrays.asList(usuario, usuario1));

		Carne carne = new Carne(null, CarneEnum.AO_PONTO.getDescricao());
		Carne carne1 = new Carne(null, CarneEnum.BEM_PASSADA.getDescricao());

		carneRepository.saveAll(Arrays.asList(carne, carne1));

		Pao pao = new Pao(null, PaoEnum.AUSTRALIANO.getDescricao());
		Pao pao1 = new Pao(null, PaoEnum.GERGELIM.getDescricao());

		paoRepository.saveAll(Arrays.asList(pao, pao1));

		Molho molho = new Molho(null, MolhoEnum.PICANTE.getDescricao());
		Molho molho1 = new Molho(null, MolhoEnum.MAIONESE.getDescricao());
		Molho molho2 = new Molho(null, MolhoEnum.BACON.getDescricao());

		molhoRepository.saveAll(Arrays.asList(molho, molho1, molho2));

		List<Molho> molhosRequeridos = molhoRepository
				.findByNomeMolhoIn(Arrays.asList(molho.getNomeMolho(), molho2.getNomeMolho()));

		Pedido pedido = new Pedido(null, usuario1, pao, carne, false, false, true, true, new Date(), false, null);

		data.set(data.get(Calendar.YEAR), data.get(Calendar.MONTH) + 1, 11);

		Pedido pedido1 = new Pedido(null, usuario1, pao1, carne1, true, true, true, false, data.getTime(), false, molhosRequeridos);

		pedidoRepository.saveAll(Arrays.asList(pedido, pedido1));

	}

}
