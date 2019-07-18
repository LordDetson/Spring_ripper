package by.babanin;

import by.babanin.dao.SpeakerRepository;
import by.babanin.entity.Speaker;
import by.babanin.entity.Talk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AppTest {
    @Autowired
    private SpeakerRepository speakerRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        Speaker babaninDmitry = new Speaker("Babanin Dmitry");
        Speaker pochevalinNickita = new Speaker("Pochevalin Nickita");
        babaninDmitry.addTalk(new Talk(
                LocalDateTime.of(2019, 7, 15, 19, 0),"Spring Framework Core"));
        babaninDmitry.addTalk(new Talk(
                LocalDateTime.of(2019, 7, 15, 20, 0), "New in Java 8"));

        pochevalinNickita.addTalk(new Talk(
                LocalDateTime.of(2019, 7, 15, 18, 0), "Архитектура ЭВМ"));

        speakerRepository.save(Arrays.asList(babaninDmitry, pochevalinNickita));
    }

    @Test
    public void testCount() {
        System.out.println("----- Number of speakers TEST -----");
        System.out.println("Speakers count: " + speakerRepository.count());
        System.out.println("-----------------------------------");
    }

    @Test
    public void testFindAll() {
        System.out.println("----- All speakers ------");
        List<Speaker> allSpeaker = speakerRepository.getAllSpeaker();
        allSpeaker.forEach(speaker -> System.out.println(speaker.getName()));
        System.out.println("-------------------------");
    }

    @Test
    public void testFindByName() {
        System.out.println("----- All talks of Babanin Dmitry -----");
        Speaker speaker = speakerRepository.findByName("Babanin Dmitry").get(0);
        speaker.getTalks().forEach(talk -> System.out.println(talk.toString()));
        System.out.println("---------------------------------------");
    }

    @After
    public void clean() {
        speakerRepository.deleteAll();
    }
}
