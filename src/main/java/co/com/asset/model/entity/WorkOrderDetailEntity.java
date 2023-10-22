package co.com.asset.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "work_order_detail")
public class WorkOrderDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "work_order_id")
	private Long workOrderId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private WorkOrderEntity workOrder;
	
	private String notes;
	private LocalDate serviceDateTimeStart;
	private LocalDate serviceDateTimeEnd;
	
	private String AttendedBy;
	
}
