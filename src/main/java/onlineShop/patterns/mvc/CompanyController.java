package onlineShop.patterns.mvc;

public class CompanyController {
    private Company company;
    private CompanyView companyView;

    public CompanyController(Company company, CompanyView companyView) {
        this.company = company;
        this.companyView = companyView;
    }

    public int getCompanyID() {
        return company.getCompanyID();
    }

    public void setCompanyID(int companyID) {
        company.setCompanyID(companyID);
    }

    public String getCompanyName() {
        return company.getCompanyName();
    }

    public void setCompanyName(String name) {
        company.setCompanyName(name);
    }

    public double getSharePrice() {
        return company.getSharePrice();
    }

    void setSharePrice(double sharePrice) {
        company.setSharePrice(sharePrice);
    }


    public void updateView() {
        companyView.printDetails(company.getCompanyID(), company.getCompanyName(), company.getSharePrice());
    }
}
