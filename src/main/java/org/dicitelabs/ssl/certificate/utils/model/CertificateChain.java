package org.dicitelabs.ssl.certificate.utils.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CertificateChain {
    private Certificate certificate;
    private List<Certificate> signCertificates;

    public CertificateChain(Certificate certificate, List<Certificate> signCertificates) {
        this.certificate = certificate;
        this.signCertificates = signCertificates;
    }

    public CertificateChain(Certificate certificate) {
        this.certificate = certificate;
        this.signCertificates = new ArrayList<>();
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public List<Certificate> getSignCertificates() {
        return signCertificates;
    }

    public void setSignCertificates(List<Certificate> signCertificates) {
        this.signCertificates = signCertificates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateChain that = (CertificateChain) o;
        return getCertificate().equals(that.getCertificate()) &&
                getSignCertificates().equals(that.getSignCertificates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCertificate(), getSignCertificates());
    }
}
