package facades;
import dtos.TripDTO;
import entities.Trip;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TripFacade {

    private static TripFacade instance;
    private static EntityManagerFactory emf;


    public static TripFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<TripDTO> getallTrip() {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<TripDTO> query = em.createQuery("SELECT new dtos.TripDTO(t) FROM Trip t", TripDTO.class);
            List<TripDTO> tripDTOS = query.getResultList();
            return tripDTOS;
        } finally {
            em.close();
        }
    }

    public TripDTO createTrip(TripDTO tripDTO) {
        EntityManager em = getEntityManager();
        Trip trip = new Trip(tripDTO.getName(), tripDTO.getTime(), tripDTO.getLocation(), tripDTO.getLocation());
        try{
            em.getTransaction().begin();
            em.persist(trip);
            em.getTransaction().commit();
            return new TripDTO(trip);
        } finally {
            em.close();
        }
    }

    public void deleteTrip(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Trip trip = em.find(Trip.class, id);
            em.remove(trip);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public TripDTO editTrip(TripDTO tripDTO) {
        EntityManager em = emf.createEntityManager();
        Trip trip = em.find(Trip.class, tripDTO.getId());
        trip.setName(tripDTO.getName());
        trip.setTime(tripDTO.getTime());
        trip.setLocation(tripDTO.getLocation());
        trip.setDuration(tripDTO.getDuration());
        try {
            em.getTransaction().begin();
            em.merge(trip);
            em.getTransaction().commit();
            return new TripDTO(trip);
        } finally {
            em.close();
        }
    }


}
