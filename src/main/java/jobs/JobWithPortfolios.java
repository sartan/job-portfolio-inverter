package jobs;

import java.util.List;

public class JobWithPortfolios {
  private String urn;
  private String name;
  private List<Portfolio> portfolios;


  public JobWithPortfolios() {
  }

  public JobWithPortfolios(String urn, String name, List<Portfolio> portfolios) {
    this.urn = urn;
    this.name = name;
    this.portfolios = portfolios;
  }

  public String getUrn() {
    return urn;
  }

  public String getName() {
    return name;
  }

  public List<Portfolio> getPortfolios() {
    return portfolios;
  }

  @Override
  public String toString() {
    return "Job{" +
      "urn='" + urn + '\'' +
      ", name='" + name + '\'' +
      ", portfolios=" + portfolios +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    JobWithPortfolios job = (JobWithPortfolios) o;

    if (urn != null ? !urn.equals(job.urn) : job.urn != null) return false;
    if (name != null ? !name.equals(job.name) : job.name != null) return false;
    return portfolios != null ? portfolios.equals(job.portfolios) : job.portfolios == null;

  }

  @Override
  public int hashCode() {
    int result = urn != null ? urn.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (portfolios != null ? portfolios.hashCode() : 0);
    return result;
  }
}
