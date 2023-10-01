package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent (ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .organization_name("Best Sell")
                .address("Chiang mai")
                .build());

        organizerRepository.save(Organizer.builder()
                .organization_name("Banana")
                .address("Bangkok")
                .build());

        organizerRepository.save(Organizer.builder()
                .organization_name("Big D")
                .address("Phuket")
                .build());

        organizerRepository.save(Organizer.builder()
                .organization_name("Small C")
                .address("Chiang mai")
                .build());
    }
}
