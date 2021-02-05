package be.fooda.frontend.model.store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.SortableField;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Field
    @SortableField
    private LocalDateTime openTime;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Field
    @SortableField
    private LocalDateTime closeTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @ToString.Exclude
    @ContainedIn
    private Store store;
}

