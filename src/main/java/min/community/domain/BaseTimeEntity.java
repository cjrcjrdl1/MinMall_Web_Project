package min.community.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //해당 클래스 상속시 필드들을 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 추가
public abstract class BaseTimeEntity{

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
