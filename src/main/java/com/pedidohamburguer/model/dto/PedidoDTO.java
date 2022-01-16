package com.pedidohamburguer.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pedidohamburguer.model.entity.Pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

	private Integer id;

	private UsuarioDTO usuarioDTO;

	private PaoDTO paoDTO;

	private CarneDTO carneDTO;

	private List<MolhoDTO> molhoDTO = new ArrayList<>();

	private Boolean alface;
	private Boolean tomate;
	private Boolean bacon;
	private Boolean cebolaCaramelizada;
	private Boolean concluido;

	private Date dataCriacao;

	public PedidoDTO(Pedido obj) {

		for (int i = 0; i < obj.getMolhos().size(); i++) {

			molhoDTO.add(new MolhoDTO(obj.getMolhos().get(i).getId(), obj.getMolhos().get(i).getNomeMolho()));

		}

		id = obj.getId();
		usuarioDTO = new UsuarioDTO(obj.getUsuario().getId(), obj.getUsuario().getNome(),
				obj.getUsuario().getSobrenome(), obj.getUsuario().getAdmin());
		paoDTO = new PaoDTO(obj.getPao().getId(), obj.getPao().getNome());
		carneDTO = new CarneDTO(obj.getCarne().getId(), obj.getCarne().getPontoCarne());
		// molhoDTO.addAll(obj.getMolhos());
		alface = obj.getAlface();
		tomate = obj.getTomate();
		bacon = obj.getBacon();
		cebolaCaramelizada = obj.getCebolaCaramelizada();
		concluido = obj.getConcluido();
		dataCriacao = obj.getDataCriacao();
	}

}
