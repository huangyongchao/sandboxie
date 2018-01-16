package app.repository;

import app.model.Sandboxie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface SandboxieRepository extends CrudRepository<Sandboxie, Integer>, QueryByExampleExecutor<Sandboxie> {

}
