package org.thryft.native_;

public final class UrnParser {
%%{
    machine UrnParser;
    include Rfc3986 "Rfc3986.rl";
    main := 'urn:'
                (segment_nz_nc >{ mark = fpc; } %{ namespaceIdentifier = new String(data, mark, fpc - mark); })
                ':'
                (segment_nz >{ mark = fpc; } %{ namespaceSpecificString = new String(data, mark, fpc - mark); });
}%%

    public static URN parseUrn(final String urn) {
        if (urn == null) {
            throw new NullPointerException();
        }

        // Ragel state machine variables
        byte[] data = urn.getBytes();
        int p = 0;
        int pe = data.length;
        int eof = pe;
        int cs = 0;

        // Variables used by actions
        int mark = 0;
        String namespaceIdentifier = null;
        String namespaceSpecificString = null;

%% write init;
%% write exec;

        if (namespaceIdentifier == null) {
            throw new IllegalArgumentException(urn);
        } else if (namespaceSpecificString == null) {
            throw new IllegalArgumentException(urn);
        }

        return new URN(namespaceIdentifier, namespaceSpecificString, urn);
    }

 %% write data;
}
