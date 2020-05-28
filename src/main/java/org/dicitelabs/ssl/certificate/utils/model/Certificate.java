package org.dicitelabs.ssl.certificate.utils.model;

import java.security.cert.X509Certificate;
import java.util.Objects;

public class Certificate {
    private X509Certificate x509Certificate;

    public Certificate(X509Certificate x509Certificate) {
        this.x509Certificate = x509Certificate;
    }

    public X509Certificate getX509Certificate() {
        return x509Certificate;
    }

    public void setX509Certificate(X509Certificate x509Certificate) {
        this.x509Certificate = x509Certificate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return getX509Certificate().equals(that.getX509Certificate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX509Certificate());
    }
}
