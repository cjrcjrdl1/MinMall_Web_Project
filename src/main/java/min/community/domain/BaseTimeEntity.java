package min.community.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass //해당 클래스 상속시 필드들을 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 추가
public abstract class BaseTimeEntity{

    @CreatedDate
    private String createdTime;

    @LastModifiedDate
    private String modifiedDate;

    @PrePersist
    public void datePrePersist() {
        this.createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.modifiedDate = createdTime;
    }

    @PreUpdate
    public void datePreUpdate() {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
