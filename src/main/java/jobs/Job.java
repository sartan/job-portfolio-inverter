package jobs;

public class Job {
  private String urn;
  private String name;

  public Job() {
  }

  public Job(String urn, String name) {
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
    return "Job{" +
      "urn='" + urn + '\'' +
      ", name='" + name + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Job job = (Job) o;

    if (urn != null ? !urn.equals(job.urn) : job.urn != null) return false;
    return name != null ? name.equals(job.name) : job.name == null;

  }

  @Override
  public int hashCode() {
    int result = urn != null ? urn.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
