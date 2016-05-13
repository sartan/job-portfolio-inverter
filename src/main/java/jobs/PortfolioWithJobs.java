package jobs;

import java.util.List;

public class PortfolioWithJobs {
  private String urn;
  private String name;
  private List<Job> jobs;

  public PortfolioWithJobs() {
  }

  public PortfolioWithJobs(String urn, String name, List<Job> jobs) {
    this.urn = urn;
    this.name = name;
    this.jobs = jobs;
  }

  public String getUrn() {
    return urn;
  }

  public String getName() {
    return name;
  }

  public List<Job> getJobs() {
    return jobs;
  }

  @Override
  public String toString() {
    return "PortfolioWithJobs{" +
      "urn='" + urn + '\'' +
      ", name='" + name + '\'' +
      ", jobs=" + jobs +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PortfolioWithJobs that = (PortfolioWithJobs) o;

    if (urn != null ? !urn.equals(that.urn) : that.urn != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return jobs != null ? jobs.equals(that.jobs) : that.jobs == null;

  }

  @Override
  public int hashCode() {
    int result = urn != null ? urn.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
    return result;
  }
}
