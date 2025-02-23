package Services;
import Connections.Query.ExecuteQueryCertificate;
import Model.Certificate;

public class CertificatesService {
    ExecuteQueryCertificate executeQueryCertificate;
    public void addCertificate(Certificate certificate){
        executeQueryCertificate =new ExecuteQueryCertificate("INSERT INTO certificates (name, achievement, gift, players_id) VALUES ('"+certificate.getName()+"', '"+certificate.getAchievement()+"', '"+certificate.getGift()+"', "+certificate.getPlayersId()+")");
    }
    public void deleteCertificate(int certificatePosition){
        executeQueryCertificate =new ExecuteQueryCertificate("DELETE FROM certificates WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM certificates ORDER BY id LIMIT 1 OFFSET "+(certificatePosition-1)+") AS subquery)");
    }
    public void seeCertificates(){
        executeQueryCertificate=new ExecuteQueryCertificate("SELECT name FROM certificates");
    }
    public Certificate getCertificate(int certificatePosition){
        executeQueryCertificate =new ExecuteQueryCertificate("SELECT * FROM certificates ORDER BY id LIMIT 1 OFFSET "+(certificatePosition-1));
        return executeQueryCertificate.getCertificate();
    }
    public void updateCertificate(Certificate certificate){
        executeQueryCertificate =new ExecuteQueryCertificate("UPDATE certificates SET name = '"+certificate.getName()+"', achievement = '"+certificate.getAchievement()+"', gift = '"+certificate.getGift()+"' WHERE id = "+certificate.getId());
    }
}
