package app.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sandboxie implements Serializable{
  private static final long serialVersionUID = -4231190658802056424L;
  @Id
  @GeneratedValue
  private Integer id;
  private String path;
  private String returndata;
  private String returntype;


  public Sandboxie(String path, String returndata) {
    this.path = path;
    this.returndata = returndata;
  }

  public Sandboxie() {
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getReturndata() {
    return returndata;
  }

  public void setReturndata(String returndata) {
    this.returndata = returndata;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getReturntype() {
    return returntype;
  }

  public void setReturntype(String returntype) {
    this.returntype = returntype;
  }
}
