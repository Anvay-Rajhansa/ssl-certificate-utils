package org.dicitelabs.ssl.certificate.utils.helper;

import org.dicitelabs.ssl.certificate.utils.model.Certificate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CertificateParser {

    private static final String BEGIN = "-----BEGIN CERTIFICATE-----";
    private static final String END = "-----END CERTIFICATE-----";

    public static List<Certificate> parseCertificateChainAndGenerateList(String certificateChain) throws CertificateException {

        if (certificateChain == null || certificateChain.isEmpty()) {
            throw new IllegalStateException("Given certificate chain is empty or null.");
        }

        List<Certificate> certificateList = new ArrayList<>();
        String[] pemCerts = certificateChain.split(END);

        for (String pemCert : pemCerts) {
            Certificate certificate = generateCertificate(pemCert + END);
            certificateList.add(certificate);
        }

        return certificateList;
    }

    public static Certificate generateCertificate(final String certificate) throws CertificateException {

        if (certificate == null || certificate.isEmpty()) {
            throw new IllegalStateException("Given certificate string is empty or null");
        }

        String certificateInPemFormat = certificate.replace(BEGIN, "").replace(END, "");

        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        byte[] certificateData = Base64.getDecoder().decode(certificateInPemFormat);
        InputStream inputStream = new ByteArrayInputStream(certificateData);
        X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(inputStream);

        return new Certificate(cert);
    }
}
