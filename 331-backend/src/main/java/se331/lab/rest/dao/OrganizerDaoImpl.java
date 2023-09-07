package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;
    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .organization_name("Best Sell")
                .address("Chiang mai")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .organization_name("Banana")
                .address("Bangkok")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .organization_name("Big D")
                .address("Phuket")
                .build());
        organizerList.add(Organizer.builder()
                .id(1001L)
                .organization_name("Small C")
                .address("Chiang mai")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}
