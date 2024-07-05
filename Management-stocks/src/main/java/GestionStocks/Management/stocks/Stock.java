package GestionStocks.Management.stocks;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Stock {


    // Getters and Setters
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private int quantity;
        private double price;
        public Stock() {
        }

        // Constructor with fields
        public Stock(String name, int quantity, double price) {
                this.name = name;
                this.quantity = quantity;
                this.price = price;
        }

    public void setId(Long id) {
                this.id = id;
        }

    public void setName(String name) {
                this.name = name;
        }

    public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

    public void setPrice(double price) {
                this.price = price;
        }

        // toString method
        @Override
        public String toString() {
                return "Stock{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", quantity=" + quantity +
                        ", price=" + price +
                        '}';
        }

    }


