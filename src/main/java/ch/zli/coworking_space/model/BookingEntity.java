package ch.zli.coworking_space.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "BOOKING")
public class BookingEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID id = UUID.randomUUID();

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "is_accepted", nullable = false)
    private Boolean isAccepted;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity placeEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return id.equals(that.id) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && isAccepted.equals(that.isAccepted) && memberEntity.equals(that.memberEntity) && placeEntity.equals(that.placeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, isAccepted, memberEntity, placeEntity);
    }
}
