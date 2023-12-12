package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.BulletinDePaie;
import ma.emsi.pfa.repositories.BulletinDePaieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BulletinDePaieService {
    private final BulletinDePaieRepository bulletinDePaieRepository;

    public BulletinDePaieService(BulletinDePaieRepository bulletinDePaieRepository) {
        this.bulletinDePaieRepository = bulletinDePaieRepository;
    }

    public List<BulletinDePaie> getAllBulletinsDePaie() {
        return bulletinDePaieRepository.findAll();
    }

    public Optional<BulletinDePaie> getBulletinDePaieById(Long id) {
        return bulletinDePaieRepository.findById(id);
    }

    public BulletinDePaie createBulletinDePaie(BulletinDePaie bulletinDePaie) {
        return bulletinDePaieRepository.save(bulletinDePaie);
    }

    public BulletinDePaie updateBulletinDePaie(Long id, BulletinDePaie updatedBulletinDePaie) {
        Optional<BulletinDePaie> existingBulletinDePaie = bulletinDePaieRepository.findById(id);
        if (existingBulletinDePaie.isPresent()) {
            BulletinDePaie bulletinDePaieToUpdate = existingBulletinDePaie.get();
            bulletinDePaieToUpdate.setSalaire_base(updatedBulletinDePaie.getSalaire_base());
            bulletinDePaieToUpdate.setSalaire_brut(updatedBulletinDePaie.getSalaire_brut());
            bulletinDePaieToUpdate.setNet_apayer(updatedBulletinDePaie.getNet_apayer());
            bulletinDePaieToUpdate.setDate_entre(updatedBulletinDePaie.getDate_entre());
            bulletinDePaieToUpdate.setStatus(updatedBulletinDePaie.getStatus());
            return bulletinDePaieRepository.save(bulletinDePaieToUpdate);
        } else {
            return null;
        }
    }

    public void deleteBulletinDePaie(Long id) {
        bulletinDePaieRepository.deleteById(id);
    }
}
