package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Tran")
@Data
public class Tran {
	
	  @Valid
	  @EmbeddedId
	  private TranId tranId;	
	  private Character tranOption;
	  private Integer tranProdCode;
	  
	  @NotNull(message="Tran code shoudl not be null")
	  private String tranCode;
	  private LocalDate tranValueDate;
	  private Integer tranAcingBrnCode;
	  private String tranAcnum;
	  private String tranGlaccCode;
	  private Character tranDbCrFlg;
	  private Character tranTypeOfTran;
	  private String tranCurrCode;
	  private Double tranAmount;
	  private String tranBaseCurrCode;
	  private Double tranBaseCurrConvRate;
	  private Double tranBaseCurrEqAmt;
	  private Boolean tranSystemPostedTran=false;
	  private Double tranAcCancelAmt=0.0;
	  private String tranNarrDtl1;
	  private String tranNarrDtl2;
	  private String tranNarrDtl3;
	  private LocalDateTime tranEntdOn;
	  private String tranEntdBY;

}
