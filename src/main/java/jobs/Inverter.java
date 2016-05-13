package jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Inverter {

  public List<JobWithPortfolios> invert(List<PortfolioWithJobs> portfoliosWithJobs) {

    return portfoliosByJob(portfoliosWithJobs)
      .entrySet()
      .stream()
      .map(e -> new JobWithPortfolios(e.getKey().getUrn(), e.getKey().getName(), e.getValue()))
      .collect(toList());
  }

  private Map<Job, List<Portfolio>> portfoliosByJob(List<PortfolioWithJobs> portfoliosWithJobs) {
    Map<Job, List<Portfolio>> result = new HashMap<>();

    portfoliosWithJobs.forEach(
      portfolio -> portfolio.getJobs().forEach(
        job -> result
          .computeIfAbsent(job, v -> new ArrayList<>())
          .add(new Portfolio(portfolio.getUrn(), portfolio.getName()))
      )
    );

    return result;
  }
}
