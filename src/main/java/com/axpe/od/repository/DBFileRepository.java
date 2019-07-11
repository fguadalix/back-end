//package com.axpe.od.repository;
//
//import com.axpe.od.model.DBFile;
//import java.util.List;
//import java.util.Optional;
//import javax.transaction.Transactional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface DBFileRepository extends JpaRepository<DBFile, Long> {
//
//  Optional<DBFile> findByFileIdAndProfessional_ProfessionalId(Long id, Long professional_id);
//
//  @Query("select f.fileId,f.fileName,f.fileType from DBFile f where f.professional.professionalId = :professional_id")
//  List<DBFile> findByProfessional_ProfessionalId(Long professional_id);
//
//  @Modifying(clearAutomatically = true)
//  @Transactional
//  @Query("DELETE FROM DBFile f WHERE f.fileId = ?1")
//  void deleteById(Long id);
//  
//  /**PARA  BUSCAR POR POSITION */
//  
//  Optional<DBFile> findByFileIdAndPosition_PositionId(Long id, Long position_id);
//  
//  @Query("select f.fileId,f.fileName,f.fileType from DBFile f where f.position.positionId = :position_id")
//  List<DBFile> findByPosition_PositionId(Long position_id);
//  
//}
