package FindSorted.controller;

import FindSorted.actors.Client;

import java.util.List;


/**
 * Created by alexnagorniy on 21.08.16.
 */
public interface IClientController {

    public List<Client> getCleents();

    public List<Client> findByName(String findedName);

    public List<Client> findByPhone(String findedPhone);

    public List<Client> sortingById(List<Client> listForSort);

    public List<Client> sortingByCity(List<Client> listForSort);

    public List<Client> sortingByIdAbdCity(List<Client> listForSort);

  /*  List<Company> getListOfCompanies();

    List<Company> getListOfCompaniesByService(String serviceName);

    List<Service> getListOfServices();

    List<Comment> getListOfComments(String companyName);

    ContactInfo updateMyInfo(String city, String phone, String email);

    Service chooseService(Service service);

    Company chooseCompany(Company company);

    Comment addComment(String companyName, String feedback);

    Comment deleteComment(String feedback);*/
}
