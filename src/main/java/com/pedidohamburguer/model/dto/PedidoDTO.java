package com.pedidohamburguer.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

	private Set<MolhoDTO> molhoDTO = new HashSet<>();

	private Boolean alface;
	private Boolean tomate;
	private Boolean bacon;
	private Boolean cebolaCaramelizada;
	private Boolean concluido;

	private Date dataCriacao;

	public PedidoDTO(Pedido obj) {
		id = obj.getId();
		usuarioDTO = new UsuarioDTO(obj.getUsuario().getId(), obj.getUsuario().getNome(),
				obj.getUsuario().getSobrenome(), obj.getUsuario().getAdmin());
		paoDTO = new PaoDTO(obj.getPao().getId(), obj.getPao().getNome());
		carneDTO = new CarneDTO(obj.getCarne().getId(), obj.getCarne().getPontoCarne());
//		arrumar o molho dps
		molhoDTO = new HashSet(obj.getMolhos());
		alface = obj.getAlface();
		tomate = obj.getTomate();
		bacon = obj.getBacon();
		cebolaCaramelizada = obj.getCebolaCaramelizada();
		concluido = obj.getConcluido();
		dataCriacao = obj.getDataCriacao();
	}

}
