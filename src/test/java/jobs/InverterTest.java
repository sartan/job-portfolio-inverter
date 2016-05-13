package jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class InverterTest {

  private List<PortfolioWithJobs> portfoliosWithJobs;
  private List<JobWithPortfolios> jobsWithPortfolios;

  private static final ObjectMapper mapper = new ObjectMapper();

  @Before
  public void setUp() throws Exception {
    portfoliosWithJobs = readFile("portfolios_with_jobs.json", PortfolioWithJobs[].class);
    jobsWithPortfolios = readFile("jobs_with_portfolios.json", JobWithPortfolios[].class);
  }

  @Test
  public void invert() {
    Inverter inverter = new Inverter();

    List<JobWithPortfolios> result = inverter.invert(portfoliosWithJobs);

    assertThat(result, containsInAnyOrder(jobsWithPortfolios.toArray()));
  }

  private static <T> List<T> readFile(String fileName, Class<T[]> clazz) {
    try {
      URL file = InverterTest.class.getResource("/" + fileName);
      return asList(mapper.readValue(file, clazz));
    } catch (IOException e) {
      throw new RuntimeException(format("Could not map data in %s to %s", fileName, clazz.getSimpleName()), e);
    }
  }

}
