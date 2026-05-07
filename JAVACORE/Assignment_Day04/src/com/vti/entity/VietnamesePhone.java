package com.vti.entity;

public class VietnamesePhone extends Phone{

    @Override
    public void insertContact(String name, String phone) {
        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                System.out.println("Contact da ton tai!");

                return;
            }
        }

        contacts.add(new Contact(name, phone));

        System.out.println("Them contact thanh cong!");
    }

    @Override
    public void removeContact(String name) {
        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getName().equalsIgnoreCase(name)) {

                contacts.remove(i);

                found = true;

                System.out.println("Xoa thanh cong!");

                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay contact!");
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        boolean found = false;

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                c.setPhone(newPhone);

                found = true;

                System.out.println("Cap nhat thanh cong!");

                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay contact!");
        }
    }

    @Override
    public void searchContact(String name) {
        boolean found = false;

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                System.out.println(c);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay contact!");
        }
    }
    public void showContacts() {

        if (contacts.isEmpty()) {

            System.out.println("Danh ba rong!");

            return;
        }

        for (Contact c : contacts) {

            System.out.println(c);
        }
    }
}
