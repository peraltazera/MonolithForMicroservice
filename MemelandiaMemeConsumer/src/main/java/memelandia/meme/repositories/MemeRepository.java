package memelandia.meme.repositories;

import memelandia.meme.core.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<Meme, String> {
}
