package jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Inverter {

  public List<JobWithPortfolios> invert(List<PortfolioWithJobs> portfoliosWithJobs) {

    return portfoliosByJobs(portfoliosWithJobs)
      .entrySet()
      .stream()
      .map(
        entry -> {
          Job job = entry.getKey();
          List<Portfolio> portfolios = entry.getValue();
          return new JobWithPortfolios(job.getUrn(), job.getName(), portfolios);
        }
      )
      .collect(toList());
  }

  private Map<Job, List<Portfolio>> portfoliosByJobs(List<PortfolioWithJobs> portfoliosWithJobs) {
    Map<Job, List<Portfolio>> result = new HashMap<>();

    portfoliosWithJobs.forEach(
      portfolio -> portfolio.getJobs().forEach(
        job -> {
          if (!result.containsKey(job)) {
            result.put(job, new ArrayList<>());
          }
          result.get(job).add(new Portfolio(portfolio.getUrn(), portfolio.getName()));
        }
      )
    );

    return result;
  }
}
