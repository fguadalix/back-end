package com.axpe.od.model;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Agenda extends Auditable implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Integer agendaId;
  private String text;
  private boolean marked; 
  private String username;

}
