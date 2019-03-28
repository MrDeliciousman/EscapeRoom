package edu.cnm.deepdive.escaperoom.model.dao;

import static org.junit.Assert.*;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import edu.cnm.deepdive.escaperoom.model.EscapeRoomDB;
import edu.cnm.deepdive.escaperoom.model.entity.Scenario;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ScenarioDaoTest {

  private EscapeRoomDB scenarioDB;
  private ScenarioDao scenarioDao;

  @Before
  public void setUp() throws Exception {
    Context context = InstrumentationRegistry.getTargetContext();
    scenarioDB = Room.inMemoryDatabaseBuilder(context, EscapeRoomDB.class).build();
    scenarioDao = scenarioDB.getScenarioDao();
  }

  @Test
  public void select() {
    Scenario scenario = new Scenario();
    String title = "Test APOD instance";
    scenario.setTitle(title);
    List<Scenario> testList = new ArrayList<>();
    testList.add(scenario);
    List<Long> ids = scenarioDao.insert(testList);
    Scenario testScenario = scenarioDao.findAllByScenarioId(ids.get(0));
    assertEquals(title, testScenario.getTitle());
  }
}