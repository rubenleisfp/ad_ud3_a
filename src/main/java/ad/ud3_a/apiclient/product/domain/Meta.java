package ad.ud3_a.apiclient.product.domain;

import java.util.Objects;

public  class Meta {
        private String createdAt;
        private String updatedAt;
        private String barcode;
        private String qrCode;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return Objects.equals(createdAt, meta.createdAt) && Objects.equals(updatedAt, meta.updatedAt) && Objects.equals(barcode, meta.barcode) && Objects.equals(qrCode, meta.qrCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt, barcode, qrCode);
    }

    @Override
    public String toString() {
        return "Meta{" +
                "createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", barcode='" + barcode + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
