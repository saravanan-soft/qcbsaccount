package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Clients")
@Data
public class Clients {
	@Id
	   @NotNull(message="clientsCode should not be null")
	 @Digits(integer = 12, fraction = 0,message="clientsCode length exist")
	private Integer clientsCode;
	 private Character clients_type_flg;
	 @Digits(integer = 6, fraction = 0,message="clientsCode length exist")
	 private Integer clientsHomeBrnCode=0;
	 @Length(max=4,message="clientsTitleCode length exist")
	 private String clientsTitleCode;
	 @Length(max=100,message="clientsName length exist")
	  private String clientsName;
	 @Length(max=25,message="clientsAlphaId length exist")
	  private String clientsAlphaId;
	 
	 @Digits(integer = 6, fraction = 0,message="clientsConstCode length exist")
	  private Long clientsConstCode;
	 @Length(max=35,message="clientsAddr1 length exist")
	  private String clientsAddr1;
	 @Length(max=35,message="clientsAddr2 length exist")
	  private String clientsAddr2;
	 @Length(max=35,message="clientsAddr3 length exist")
	  private String clientsAddr3;
	 @Length(max=35,message="clientsAddr4 length exist")
	  private String clientsAddr4;
	 @Length(max=35,message="clientsAddr5 length exist")
	  private String clientsAddr5;
	 @Length(max=6,message="clientsLocnCode length exist")
	 private String clientsLocnCode;
	 @Length(max=6,message="clientsCustCatg length exist")
	  private String clientsCustCatg;
	 @Length(max=6,message="clientsSegmentCode length exist")
	  private String clientsSegmentCode;
	 @Length(max=3,message="clientsBusdivnCode length exist")
	  private String clientsBusdivnCode;
	  private LocalDate clientsOpeningDate;
	  @Length(max=6,message="clientsGroupCode length exist")
	  private String clientsGroupCode=" ";
	  @NotNull(message="cleintsEntdBy should not be null")
	   @NotEmpty(message="cleintsEntdBy should not be empty")
	   @Length(max=8,message="cleintsEntdBy lengthe exist")
	   private String  cleintsEntdBy;
	   private LocalDateTime clientsEntdOn;

	   @OneToMany(mappedBy="clients" , cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	   private List<Acnts> acnts;
}
