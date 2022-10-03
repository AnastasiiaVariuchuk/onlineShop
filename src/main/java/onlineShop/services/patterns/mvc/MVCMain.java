package onlineShop.services.patterns.mvc;

public class MVCMain {
    public static void main(String[] args) {

        Company model = getCompany();

        CompanyView view = new CompanyView();

        CompanyController controller = new CompanyController(model, view);

        controller.updateView();

        //updating the model
        controller.setSharePrice(150.1);
        System.out.println("\nDetails after updating: ");

        controller.updateView();
    }

    private static Company getCompany(){
        Company company = new Company();
        company.setCompanyID(1);
        company.setCompanyName("Apple");
        company.setSharePrice(141.32);
        return company;
    }
}
