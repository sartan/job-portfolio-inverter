package jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inverter {

  public List<JobWithPortfolios> invert(List<PortfolioWithJobs> portfoliosWithJobs) {

    List<JobWithPortfolios> jobsWithPortfolios = new ArrayList<>();

    for (Map.Entry<Job, List<Portfolio>> entry : portfoliosByJobs(portfoliosWithJobs).entrySet()) {
      Job job = entry.getKey();
      List<Portfolio> portfolios = entry.getValue();
      jobsWithPortfolios.add(new JobWithPortfolios(job.getUrn(), job.getName(), portfolios));
    }

    return jobsWithPortfolios;
  }

  private Map<Job, List<Portfolio>> portfoliosByJobs(List<PortfolioWithJobs> portfolios) {
    Map<Job, List<Portfolio>> portfoliosByJobs = new HashMap<>();

    for (PortfolioWithJobs portfolio : portfolios) {
      for (Job job : portfolio.getJobs()) {

        if (!portfoliosByJobs.containsKey(job)) {
          portfoliosByJobs.put(job, new ArrayList<>());
        }

        portfoliosByJobs.get(job).add(new Portfolio(portfolio.getUrn(), portfolio.getName()));
      }
    }

    return portfoliosByJobs;
  }
}
