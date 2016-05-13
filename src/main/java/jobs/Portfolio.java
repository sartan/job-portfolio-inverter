package jobs;

public class Portfolio {
  private String urn;
  private String name;

  public Portfolio() {
  }

  public Portfolio(String urn, String name) {
    this.urn = urn;
    this.name = name;
  }

  public String getUrn() {
    return urn;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Portfolio{" +
      "urn='" + urn + '\'' +
      ", name='" + name + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Portfolio portfolio = (Portfolio) o;

    if (urn != null ? !urn.equals(portfolio.urn) : portfolio.urn != null) return false;
    return name != null ? name.equals(portfolio.name) : portfolio.name == null;

  }

  @Override
  public int hashCode() {
    int result = urn != null ? urn.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
