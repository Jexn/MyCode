package Projects.Project2;

/**
 * @cLassName: CustomerList
 * @author: cube
 * @description: 逻辑层
 * @date: 2019/3/22 17:06
 */
public class CustomerList {
    private Customer[] customers;
    private int total;

    public CustomerList() {
        this.customers = new Customer[100];
        this.total = 0;
    }

    /**
     * 增加用户，添加失败返回false
     *
     * @param customer
     * @return
     */
    public boolean addCustomer(Customer customer) {
        if (total < customers.length) {
            customers[total] = customer;
            total++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户信息，如果用户不存在返回false
     *
     * @param index
     * @param customer
     * @return
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index >= 0 && index < total) {
            customers[index] = customer;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除指定客户
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index) {
        if (index >= 0 && index < total) {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[--total] = null;
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取所有客户
     * @return
     */
    public Customer[] getCustomers(){
        Customer[] temp = new Customer[total];
        System.arraycopy(customers,0,temp,0, total);
        return temp;
    }

    public int getTotal() {
        return total;
    }

    /**
     * 获取指定用户
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        if (index < total){
            return customers[index];
        }else {
            return null;
        }
    }


}
