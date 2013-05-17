package org.thryft;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigDecimal;
import java.util.Random;

import org.thryft.native_.EmailAddress;
import org.thryft.native_.Url;
import org.thryft.native_.UrlParser;

import com.google.common.collect.ImmutableList;

public final class Faker {
    public final static class Address {
        public static String secondaryAddress() {
            return "Apt. 1";
        }

        public static String streetAddress() {
            return "Main St.";
        }

        public static String ukCountry() {
            return "USA";
        }

        public static String usState() {
            return "OK";
        }

        public static String zipCode() {
            return "74017";
        }
    }

    public final static class Internet {
        public static EmailAddress email() {
            return new EmailAddress("fake@example.com");
        }

        public static Url url() {
            return UrlParser.parseUrl("http://example.com");
        }

        private Internet() {
        }
    }

    public final static class Lorem {
        public static String paragraph() {
            return "Lorem";
        }

        public static String sentence() {
            return "Lorem";
        }

        public static String word() {
            return "Lorem";
        }

        private Lorem() {
        }
    }

    public final static class Name {
        public static String findName() {
            return "John Doe";
        }

        public static String firstName() {
            return "John";
        }

        public static String lastName() {
            return "Doe";
        }

        private Name() {
        }
    }

    public final static class PhoneNumber {
        public static String phoneNumber() {
            return "5555551212";
        }
    }

    public static byte[] randomBinary() {
        final byte[] binary = new byte[32];
        random.nextBytes(binary);
        return binary;
    }

    public static boolean randomBool() {
        return random.nextBoolean();
    }

    public static byte randomByte() {
        return (byte) random.nextInt();
    }

    public static BigDecimal randomDecimal() {
        return new BigDecimal(random.nextInt());
    }

    public static <EnumT extends Enum<?>> EnumT randomEnum(
            final ImmutableList<EnumT> enumerators) {
        checkArgument(enumerators.size() > 0);
        return enumerators.get(0);
    }

    public static float randomFloat() {
        return random.nextFloat();
    }

    public static short randomI16() {
        return (short) random.nextInt();
    }

    public static int randomI32() {
        return random.nextInt();
    }

    public static long randomI64() {
        return random.nextLong();
    }

    private Faker() {
    }

    private final static Random random = new Random();
}
