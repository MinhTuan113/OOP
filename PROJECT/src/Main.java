import model.*;
import service.*;
import dao.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ShopService shopservice = new ShopService();
        ReviewService reviewService = new ReviewService();
        LocationService locateService =new LocationService();
        while(true)
        {
            System.out.println("===== MENU =====");
            System.out.println("1. Quan ly gian hang");
            System.out.println("2. Quan ly danh gia");
            System.out.println("3. Quan ly dia chi nhan hang");
            System.out.println("0. Thoat");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    while(true)
                    {
                        System.out.println("===Quan ly gian hang===");
                        System.out.println("1. Them 1 shop moi");
                        System.out.println("2. Xem tat ca cac shop");
                        System.out.println("3. Cap nhat shop");
                        System.out.println("4. Dong cua shop");
                        System.out.println("5. Xoa shop");
                        System.out.println("0. Thoat");
                        int option=sc.nextInt();
                        sc.nextLine();
                        if(option==0) break;
                        switch (option)
                        {
                            case 1:
                                System.out.print("Ten shop: ");
                                String name = sc.nextLine();
                                System.out.print("Nhap mo ta: ");
                                String mota = sc.nextLine();
                                System.out.print("Nhap dia chi: ");
                                String address = sc.nextLine();
                                Shop s = new Shop(name, mota, address);
                                shopservice.createShop(s);
                                break;
                            case 2:
                                System.out.println("Danh scah cac shop: ");
                                shopservice.getAll().forEach(shop ->
                                        System.out.println(shop.getId() + " - " + shop.getName())
                                );
                                break;
                            case 3:
                                System.out.print("Nhap id Shop can sua: ");
                                int id=sc.nextInt();
                                sc.nextLine();
                                System.out.print("Mo ta moi: ");
                                String desc=sc.nextLine();
                                System.out.print("Dia chi moi: ");
                                String adr=sc.nextLine();
                                Shop update=new Shop();
                                update.setId(id);
                                update.setDescription(desc);
                                update.setAddress(adr);
                                shopservice.update(update);
                                break;
                            case 4:
                                System.out.print("Nhap id Shop can dong: ");
                                int closed=sc.nextInt();
                                shopservice.close(closed);
                                break;
                            case 5:
                                System.out.print("Nhap id Shop can xoa: ");
                                int idremove=sc.nextInt();
                                shopservice.remove(idremove);
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 2:
                    while(true)
                    {
                        System.out.println("===Quan ly danh gia===");
                        System.out.println("1. Them 1 danh gia moi");
                        System.out.println("2. Xem danh gia cua shop");
                        System.out.println("3. Sua danh gia/Review");
                        System.out.println("4. Xoa danh gia/Review");
                        System.out.println("0. Thoat");
                        int option2=sc.nextInt();
                        sc.nextLine();
                        if(option2==0) break;
                        switch (option2) {
                            case 1:
                                System.out.print("Id nguoi danh gia: ");
                                int uId=sc.nextInt();
                                sc.nextLine();
                                System.out.print("Shop ID: ");
                                int shopId = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Danh gia (tu 1 ->5): ");
                                int rating = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Comment: ");
                                String com = sc.nextLine();
                                Review r = new Review(uId, shopId, rating, com);
                                reviewService.add(r);
                                break;
                            case 2:
                                System.out.print("Nhap id shop can lay thong tin: ");
                                int sid = sc.nextInt();
                                reviewService.getbyShopId(sid).forEach(rv ->
                                        System.out.println(rv.getId() + "-" + rv.getRating() + "*-" + rv.getComment())
                                );
                                break;
                            case 3:
                                System.out.print("Id review can sua: ");
                                int rid = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Rating moi: ");
                                int newrate = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Comment moi: ");
                                String newcom = sc.nextLine();
                                Review reviewmoi = new Review();
                                reviewService.update(reviewmoi);
                                break;
                            case 4:
                                System.out.print("Nhap Id review muon xoa: ");
                                int iddelete = sc.nextInt();
                                sc.nextLine();
                                int iduserdel = sc.nextInt();
                                sc.nextLine();
                                reviewService.deleteR(iddelete, iduserdel);
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 3:
                    while(true)
                    {
                        System.out.println("===Quan ly dia chi===");
                        System.out.println("1. Them dia chi theo id nguoi dung");
                        System.out.println("2. Lay dia chi theo id nguoi dung");
                        System.out.println("3. Thay doi dia chi");
                        System.out.println("4. Xoa dia chi");
                        System.out.println("0. Thoat");
                        int option3=sc.nextInt();
                        sc.nextLine();
                        if(option3==0) break;
                        switch (option3)
                        {
                            case 1:
                                System.out.print("Nhap Id nguoi dung: ");
                                int userid=sc.nextInt();
                                sc.nextLine();
                                System.out.print("Nhap mo ta chi tiet: ");
                                String motadiachi=sc.nextLine();
                                System.out.print("Dien so dien thoai: ");
                                String sdt=sc.nextLine();
                                Location lo=new Location(userid,motadiachi,sdt);
                                locateService.add(lo);
                                break;
                            case 2:
                                System.out.print("Nhap id nguoi dung can lay dia chi: ");
                                int idngdung=sc.nextInt();
                                sc.nextLine();
                                locateService.getAll(idngdung).forEach(location ->
                                        System.out.println(location.getUserId()+"-"+location.getDetail()+"-"+location.getPhone())
                                );
                                break;
                            case 3:
                                System.out.print("Nhap id dia chi can thay doi: ");
                                int idlo=sc.nextInt();
                                sc.nextLine();
                                System.out.print("Nhap id nguoi dung muon thay doi dia chi: ");
                                int useridlo=sc.nextInt();
                                sc.nextLine();
                                System.out.print("Nhap mo ta moi: ");
                                String newdetail=sc.nextLine();
                                System.out.print("Nhap sdt moi: ");
                                String newphone=sc.nextLine();
                                Location loca=new Location(useridlo,newdetail,newphone);
                                loca.setId(idlo);
                                locateService.updateLocate(loca);
                                break;
                            case 4:
                                System.out.print("Nhap id dia chi can xoa: ");
                                int iddele=sc.nextInt();
                                sc.nextLine();
                                locateService.delteLocate(iddele);
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}