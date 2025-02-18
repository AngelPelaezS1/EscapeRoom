package Services;
import Connections.Query.ExecuteQueryCertificate;
import Model.Certificate;

public class CertificatesService {
    public void addCertificate(Certificate certificate){
        String name=certificate.getName();
        String achievement=certificate.getAchievement();
        String gift=certificate.getGift();
        int players_id=certificate.getPlayersId();
        ExecuteQueryCertificate executeQueryCertificate =new ExecuteQueryCertificate("INSERT INTO certificates (name, achievement, gift, players_id) VALUES ('"+name+"', '"+achievement+"', "+gift+", "+players_id+")");
    }
    public void deleteCertificate(int certificatePosition){
        ExecuteQueryCertificate executeQueryCertificate =new ExecuteQueryCertificate("DELETE FROM certificates WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM certificates ORDER BY id LIMIT 1 OFFSET "+(certificatePosition-1)+") AS subquery)");
    }
    public void seeCertificates(){
        ExecuteQueryCertificate executeQueryCertificate=new ExecuteQueryCertificate("SELECT name FROM certificates");
    }

    public Certificate getCertificate(int certificatePosition){
        ExecuteQueryCertificate executeQueryCertificate =new ExecuteQueryCertificate("SELECT * FROM certificates ORDER BY id LIMIT 1 OFFSET "+(certificatePosition-1));
        return executeQueryCertificate.getCertificate();
    }

    public void updateCertificate(Certificate certificate){
        ExecuteQueryCertificate executeQueryCertificate =new ExecuteQueryCertificate("UPDATE certificates SET name = '"+certificate.getName()+"', achievement = '"+certificate.getAchievement()+"', gift = '"+certificate.getGift()+"' WHERE id = "+certificate.getId());
    }
}
