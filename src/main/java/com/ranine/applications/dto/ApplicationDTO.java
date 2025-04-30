package com.ranine.applications.dto;

import java.util.Date;
import com.ranine.applications.entities.Editeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {
	private Long idApp;
	private String nomApp;
	private Double nbtl;
	private Date releasedate;
	private Editeur editeur;
	private String nomEdit;

}
