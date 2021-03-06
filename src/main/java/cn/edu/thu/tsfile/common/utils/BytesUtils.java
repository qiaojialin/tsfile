package cn.edu.thu.tsfile.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.thu.tsfile.common.conf.TSFileConfig;

/**
 * BytesUtils is a utility class. It provide conversion among byte array and
 * other type including integer, long, float, boolean, double and string. <br>
 * It also provide other usable function as follow:<br>
 * reading function which receives InputStream. <br>
 * concat function to join a list of byte array to one.<br>
 * get and set one bit in a byte array.
 * 
 * @author kangrong
 *
 */
public class BytesUtils {
	private static final Logger LOG = LoggerFactory.getLogger(BytesUtils.class);

	/**
	 * byte[] convert to int
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] intToBytes(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	public static byte[] intToTwoBytes(int i) {
		assert i <= 0xFFFF;
		byte[] ret = new byte[2];
		ret[1] = (byte) (i & 0xFF);
		ret[0] = (byte) ((i >> 8) & 0xFF);
		return ret;
	}
	
    public static int twoBytesToInt(byte[] ret){
    	assert ret.length == 2;
    	int value = 0;
    	value |= ret[0];
    	value = value << 8;
    	value |= ret[1];
    	return value;
    }

	/**
	 * integer convert to byte array, then write four bytes to parameter desc
	 * start from index:offset
	 * 
	 * @param i
	 * @param desc
	 *            : byte array be written
	 * @param offset
	 *            : position in desc byte array that conversion result should
	 *            start
	 * @return
	 */
	public static byte[] intToBytes(int i, byte[] desc, int offset) {
		assert desc.length - offset >= 4;
		desc[0 + offset] = (byte) ((i >> 24) & 0xFF);
		desc[1 + offset] = (byte) ((i >> 16) & 0xFF);
		desc[2 + offset] = (byte) ((i >> 8) & 0xFF);
		desc[3 + offset] = (byte) (i & 0xFF);
		return desc;
	}

	/**
	 * byte[] convert to int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int bytesToInt(byte[] bytes) {
		int value = 0;
		// high bit to low
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (bytes[i] & 0x000000FF) << shift;
		}
		return value;
	}

	/**
	 * convert four-bytes byte array cut from parameters to integer.
	 * 
	 * @param bytes
	 *            - source bytes which length should be greater than 4
	 * @param offset
	 *            - position in parameter byte array that conversion result
	 *            should start
	 * @return
	 */
	public static int bytesToInt(byte[] bytes, int offset) {
		assert bytes.length - offset >= 4;
		int value = 0;
		// high bit to low
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (bytes[offset + i] & 0x000000FF) << shift;
		}
		return value;
	}

	/**
	 * convert float to byte
	 * 
	 * @param x
	 */
	public static byte[] floatToBytes(float x) {
		byte[] b = new byte[4];
		int l = Float.floatToIntBits(x);
		for (int i = 3; i >= 0; i--) {
			b[i] = new Integer(l).byteValue();
			l = l >> 8;
		}
		return b;
	}

	/**
	 * float convert to boolean, then write four bytes to parameter desc start
	 * from index:offset
	 * 
	 * @param x
	 * @param desc
	 *            : byte array be written
	 * @param offset
	 *            : position in desc byte array that conversion result should
	 *            start
	 * @return
	 */
	public static void floatToBytes(float x, byte[] desc, int offset) {
		assert desc.length - offset >= 4;
		int l = Float.floatToIntBits(x);
		for (int i = 3 + offset; i >= offset; i--) {
			desc[i] = new Integer(l).byteValue();
			l = l >> 8;
		}
	}

	/**
	 * convert byte to float
	 *
	 * @param b
	 * @return
	 */
	public static float bytesToFloat(byte[] b) {
		assert b.length == 4;
		int l;
		l = b[3];
		l &= 0xff;
		l |= ((long) b[2] << 8);
		l &= 0xffff;
		l |= ((long) b[1] << 16);
		l &= 0xffffff;
		l |= ((long) b[0] << 24);
		return Float.intBitsToFloat(l);
	}

	/**
	 * convert four-bytes byte array cut from parameters to float.
	 * 
	 * @param bytes
	 *            - source bytes which length should be greater than 4
	 * @param offset
	 *            - position in parameter byte array that conversion result
	 *            should start
	 * @return
	 */
	public static float bytesToFloat(byte[] b, int offset) {
		assert b.length - offset >= 4;
		int l;
		l = b[offset + 3];
		l &= 0xff;
		l |= ((long) b[offset + 2] << 8);
		l &= 0xffff;
		l |= ((long) b[offset + 1] << 16);
		l &= 0xffffff;
		l |= ((long) b[offset] << 24);
		return Float.intBitsToFloat(l);
	}

	/**
	 * convert double to byte
	 * 
	 * @param data
	 * @return byte[]
	 */
	public static byte[] doubleToBytes(double data) {
		byte[] bytes = new byte[8];
		long value = Double.doubleToLongBits(data);
		for (int i = 7; i >= 0; i--) {
			bytes[i] = new Long(value).byteValue();
			value = value >> 8;
		}
		return bytes;
	}

	/**
	 * convert double to byte into the given byte array started from offset.
	 * 
	 * @param data
	 * @param offset
	 * @return byte[]
	 */
	public static void doubleToBytes(double d, byte[] bytes, int offset) {
		assert bytes.length - offset >= 8;
		long value = Double.doubleToLongBits(d);
		for (int i = 7; i >= 0; i--) {
			bytes[offset + i] = new Long(value).byteValue();
			value = value >> 8;
		}
	}

	/**
	 * convert byte array to double
	 * 
	 * @param bytes
	 * @return double
	 */
	public static double bytesToDouble(byte[] bytes) {
		long value = bytes[7];
		value &= 0xff;
		value |= ((long) bytes[6] << 8);
		value &= 0xffff;
		value |= ((long) bytes[5] << 16);
		value &= 0xffffff;
		value |= ((long) bytes[4] << 24);
		value &= 0xffffffffL;
		value |= ((long) bytes[3] << 32);
		value &= 0xffffffffffL;
		value |= ((long) bytes[2] << 40);
		value &= 0xffffffffffffL;
		value |= ((long) bytes[1] << 48);
		value &= 0xffffffffffffffL;
		value |= ((long) bytes[0] << 56);
		return Double.longBitsToDouble(value);
	}

	/**
	 * convert eight-bytes byte array cut from parameters to double.
	 * 
	 * @param bytes
	 *            - source bytes which length should be greater than 8
	 * @param offset
	 *            - position in parameter byte array that conversion result
	 *            should start
	 * @return
	 */
	public static double bytesToDouble(byte[] bytes, int offset) {
		assert bytes.length - offset >= 8;
		long value = bytes[offset + 7];
		value &= 0xff;
		value |= ((long) bytes[offset + 6] << 8);
		value &= 0xffff;
		value |= ((long) bytes[offset + 5] << 16);
		value &= 0xffffff;
		value |= ((long) bytes[offset + 4] << 24);
		value &= 0xffffffffL;
		value |= ((long) bytes[offset + 3] << 32);
		value &= 0xffffffffffL;
		value |= ((long) bytes[offset + 2] << 40);
		value &= 0xffffffffffffL;
		value |= ((long) bytes[offset + 1] << 48);
		value &= 0xffffffffffffffL;
		value |= ((long) bytes[offset] << 56);
		return Double.longBitsToDouble(value);
	}

	/**
	 * convert boolean to byte
	 * 
	 * @param x
	 */
	public static byte[] boolToBytes(boolean x) {
		byte[] b = new byte[1];
		if (x)
			b[0] = 1;
		else
			b[0] = 0;
		return b;
	}

	/**
	 * boolean convert to byte array, then write four bytes to parameter desc
	 * start from index:offset
	 * 
	 * @param x
	 * @param desc
	 *            : byte array be written
	 * @param offset
	 *            : position in desc byte array that conversion result should
	 *            start
	 * @return
	 */
	public static byte[] boolToBytes(boolean x, byte[] desc, int offset) {
		if (x)
			desc[offset] = 1;
		else
			desc[offset] = 0;
		return desc;
	}

	/**
	 * byte array to boolean
	 * 
	 * @param b
	 * @return
	 */
	public static boolean bytesToBool(byte[] b) {
		assert b.length == 1;
		if (b[0] == 0)
			return false;
		else
			return true;
	}

	/**
	 * convert one-bytes byte array cut from parameters to boolean.
	 * 
	 * @param bytes
	 *            - source bytes which length should be greater than 1
	 * @param offset
	 *            - position in parameter byte array that conversion result
	 *            should start
	 * @return
	 */
	public static boolean bytesToBool(byte[] b, int offset) {
		assert b.length - offset >= 1;
		if (b[offset] == 0)
			return false;
		else
			return true;
	}

	/**
	 * long to byte array with default converting length 8. It means the length
	 * of result byte array is 8
	 * 
	 * @param num
	 *            : Long variable to be converted
	 * @return
	 */
	public static byte[] longToBytes(long num) {
		return longToBytes(num, 8);
	}

	/**
	 * specify the result array length. then, convert long to Big-Endian byte
	 * from low to high. <br>
	 * e.g.<br>
	 * the binary presentation of long number 1000L is {6 bytes equal 0000000}
	 * 00000011 11101000<br>
	 * if len = 2, it will return byte array :{00000011 11101000}(Big-Endian) if
	 * len = 1, it will return byte array :{11101000}
	 * 
	 * @param num
	 *            :Long variable to be converted
	 * @param len
	 *            : the length of result byte array
	 * @return byte array which length equals with parameter len
	 */
	public static byte[] longToBytes(long num, int len) {
		byte[] byteNum = new byte[len];
		for (int ix = 0; ix < len; ix++) {
			byteNum[len - ix - 1] = (byte) ((num >> ix * 8) & 0xFF);
		}
		return byteNum;
	}

	/**
	 * long convert to byte array, then write four bytes to parameter desc start
	 * from index:offset
	 * 
	 * @param x
	 * @param desc
	 *            : byte array be written
	 * @param offset
	 *            : position in desc byte array that conversion result should
	 *            start
	 * @return
	 */
	public static byte[] longToBytes(long num, byte[] desc, int offset_) {
		for (int ix = 0; ix < 8; ++ix) {
			int offset = 64 - (ix + 1) * 8;
			desc[ix + offset_] = (byte) ((num >> offset) & 0xff);
		}
		return desc;
	}

	/**
	 * convert byte array to long with default length 8. namely, the
	 * 
	 * @param byteNum
	 * @return
	 */
	public static long bytesToLong(byte[] byteNum) {
		assert byteNum.length == 8;
		return bytesToLong(byteNum, 8);
	}

	/**
	 * specify the input byte array length. then, convert byte array to long
	 * value from low to high. <br>
	 * e.g.<br>
	 * the input byte array is {00000011 11101000}. if len = 2, return 1000 if
	 * len = 1, return 232(only calculate the low byte)
	 * 
	 * @param byteNum
	 *            : byte array to be converted
	 * @param len
	 *            : the length of input byte array to be convert
	 * @return byte array which length equals with parameter len
	 */
	public static long bytesToLong(byte[] byteNum, int len) {
		long num = 0;
		for (int ix = 0; ix < len; ix++) {
			num <<= 8;
			num |= (byteNum[ix] & 0xff);
		}
		return num;
	}

	/**
	 * convert eight-bytes byte array cut from parameters to long.
	 * 
	 * @param bytes
	 *            - source bytes which length should be greater than 8
	 * @param offset
	 *            - position in parameter byte array that conversion result
	 *            should start
	 * @return
	 */
	public static long bytesToLongFromOffset(byte[] byteNum, int len, int offset) {
		assert byteNum.length - offset >= len;
		long num = 0;
		for (int ix = 0; ix < len; ix++) {
			num <<= 8;
			num |= (byteNum[offset + ix] & 0xff);
		}
		return num;
	}

	/**
	 * convert string to byte array using UTF-8 encoding
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] StringToBytes(String str) {
		try {
			return str.getBytes(TSFileConfig.STRING_ENCODING);
		} catch (UnsupportedEncodingException e) {
			LOG.error("catch UnsupportedEncodingException {}", str, e);
			return null;
		}
	}

	public static String bytesToString(byte[] byteStr) {
		try {
			return new String(byteStr, TSFileConfig.STRING_ENCODING);
		} catch (UnsupportedEncodingException e) {
			LOG.error("catch UnsupportedEncodingException {}", byteStr,e);
			return null;
		}
	}

	/**
	 * join two byte arrays to one
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static byte[] concatByteArray(byte[] a, byte[] b) {
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	/**
	 * join a list of byte arrays into one array
	 * 
	 * @param list
	 * @return
	 */
	public static byte[] concatByteArrayList(List<byte[]> list) {
		int size = list.size();
		int len = 0;
		for (byte[] cs : list) {
			len += cs.length;
		}
		byte[] result = new byte[len];
		int pos = 0;
		for (int i = 0; i < size; i++) {
			int l = list.get(i).length;
			System.arraycopy(list.get(i), 0, result, pos, l);
			pos += l;
		}
		return result;
	}

	/**
	 * cut out specified length byte array from parameter start from input byte
	 * array src and return
	 * 
	 * @param src
	 * @param start
	 * @param length
	 * @return
	 */
	public static byte[] subBytes(byte[] src, int start, int length) {
		if ((start + length) > src.length)
			return null;
		if (length <= 0)
			return null;
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = src[start + i];
		}
		return result;
	}

	/**
	 * get one bit in input integer. the offset is from low to high and start
	 * with 0<br>
	 * e.g.<br>
	 * data:1000(00000000 00000000 00000011 11101000), if offset is 4, return
	 * 0(111 "0" 1000) if offset is 9, return 1(00000 "1" 1 11101000)
	 * 
	 * @param data
	 * @param offset
	 * @return
	 */
	public static int getIntN(int data, int offset) {
		offset %= 32;
		if ((data & (1 << (offset))) != 0)
			return 1;
		else
			return 0;
	}

	/**
	 * set one bit in input integer. the offset is from low to high and start
	 * with index 0<br>
	 * e.g.<br>
	 * data:1000({00000000 00000000 00000011 11101000}), if offset is 4, value
	 * is 1, return 1016({00000000 00000000 00000011 111 "1" 1000}) if offset is
	 * 9, value is 0 return 488({00000000 00000000 000000 "0" 1 11101000}) if
	 * offset is 0, value is 0 return 1000(no change)
	 * 
	 * @param data
	 * @param offset
	 * @param value
	 * @return
	 */
	public static int setIntN(int data, int offset, int value) {
		offset %= 32;
		if (value == 1)
			return (data | (1 << (offset)));
		else
			return (data & ~(1 << (offset)));
	}

	/**
	 * get one bit in input byte. the offset is from low to high and start with
	 * 0<br>
	 * e.g.<br>
	 * data:16(00010000), if offset is 4, return 1(000 "1" 0000) if offset is 7,
	 * return 0("0" 0010000)
	 * 
	 * @param data
	 * @param offset
	 * @return
	 */
	public static int getByteN(byte data, int offset) {
		offset %= 8;
		if ((data & (1 << (7 - offset))) != 0)
			return 1;
		else
			return 0;
	}

	/**
	 * set one bit in input byte. the offset is from low to high and start with
	 * index 0<br>
	 * e.g.<br>
	 * data:16(00010000), if offset is 4, value is 0, return 0({000 "0" 0000})
	 * if offset is 1, value is 1, return 18({00010010}) if offset is 0, value
	 * is 0, return 16(no change)
	 * 
	 * @param data
	 * @param offset
	 * @param value
	 * @return
	 */
	public static byte setByteN(byte data, int offset, int value) {
		offset %= 8;
		if (value == 1)
			return (byte) (data | (1 << (7 - offset)));
		else
			return (byte) (data & ~(1 << (7 - offset)));
	}

	/**
	 * get one bit in input long. the offset is from low to high and start with
	 * 0<br>
	 * 
	 * @param data
	 * @param offset
	 * @return
	 */
	public static int getLongN(long data, int offset) {
		offset %= 64;
		if ((data & (1l << (offset))) != 0)
			return 1;
		else
			return 0;
	}

	/**
	 * set one bit in input long. the offset is from low to high and start with
	 * index 0<br>
	 * 
	 * @param data
	 * @param offset
	 * @param value
	 * @return
	 */
	public static long setLongN(long data, int offset, int value) {
		offset %= 64;
		if (value == 1)
			return (data | (1l << (offset)));
		else
			return (data & ~(1l << (offset)));
	}

	/**
	 * given a byte array, read width bits from specified position bits and
	 * convert it to an integer
	 * 
	 * @param result
	 * @param pos
	 *            - not byte offset, but bit offset
	 * @param width
	 * @return
	 */
	public static int bytesToInt(byte[] result, int pos, int width) {

		int value = 0;
		int temp = 0;

		for (int i = 0; i < width; i++) {
			temp = (pos + width - 1 - i) / 8;
			value = setIntN(value, i, getByteN(result[temp], pos + width - 1 - i));
		}
		return value;
	}

	/**
	 * convert an integer to a byte array which length is width, then copy this
	 * array to the parameter result from pos
	 * 
	 * @param srcNum
	 * @param result
	 * @param pos
	 *            - not byte offset, but bit offset
	 * @param width
	 */
	public static void intToBytes(int srcNum, byte[] result, int pos, int width) {
		int temp = 0;
		for (int i = 0; i < width; i++) {
			temp = (pos + width - 1 - i) / 8;
			try {
				result[temp] = setByteN(result[temp], pos + width - 1 - i, getIntN(srcNum, i));
			} catch (Exception e) {
				LOG.error("tsfile-common BytesUtils: cannot convert an integer {} to a byte array, pos {}, width {}",
							srcNum, pos, width, e);
			}

		}
	}

	/**
	 * convert an long to a byte array which length is width, then copy this
	 * array to the parameter result from pos
	 * 
	 * @param srcNum
	 * @param result
	 * @param pos
	 *            -not byte offset, but bit offset
	 * @param width
	 */
	public static void longToBytes(long srcNum, byte[] result, int pos, int width) {
		int temp = 0;
		for (int i = 0; i < width; i++) {
			temp = (pos + width - 1 - i) / 8;
			try {
				result[temp] = setByteN(result[temp], pos + width - 1 - i, getLongN(srcNum, i));
			} catch (Exception e) {
				LOG.error("tsfile-common BytesUtils: cannot convert a long {} to a byte array, pos {}, width {}",
							srcNum, pos, width, e);
			}

		}
	}

	/**
	 * given a byte array, read width bits from specified pos bits and convert
	 * it to an long
	 * 
	 * @param result
	 * @param pos
	 *            - not byte offset, but bit offset
	 * @param width
	 * @return
	 */
	public static long bytesToLong(byte[] result, int pos, int width) {
		long value = 0;
		int temp = 0;
		for (int i = 0; i < width; i++) {
			temp = (pos + width - 1 - i) / 8;
			value = setLongN(value, i, getByteN(result[temp], pos + width - 1 - i));
		}
		return value;
	}

	/**
	 * read 8-byte array from an InputStream and convert it to a double number
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static double readDouble(InputStream in) throws IOException {
		byte[] b = safeReadInputStreamToBytes(8, in);
		return BytesUtils.bytesToDouble(b);
	}

	/**
	 * read 4-byte array from an InputStream and convert it to a float number
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static float readFloat(InputStream in) throws IOException {
		byte[] b = safeReadInputStreamToBytes(4, in);
		return BytesUtils.bytesToFloat(b);
	}

	/**
	 * read 1-byte array from an InputStream and convert it to a integer number
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static boolean readBool(InputStream in) throws IOException {
		byte[] b = safeReadInputStreamToBytes(1, in);
		return BytesUtils.bytesToBool(b);
	}

	/**
	 * read 4-byte array from an InputStream and convert it to a integer number
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static int readInt(InputStream in) throws IOException {
		byte[] b = safeReadInputStreamToBytes(4, in);
		return BytesUtils.bytesToInt(b);
	}

	/**
	 * read 8-byte array from an InputStream and convert it to a long number
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static long readLong(InputStream in) throws IOException {
		byte[] b = safeReadInputStreamToBytes(8, in);
		return BytesUtils.bytesToLong(b);
	}

	/**
	 * read bytes specified length from InputStream safely.
	 * 
	 * @param count
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] safeReadInputStreamToBytes(int count, InputStream in) throws IOException {
		byte[] bytes = new byte[count];
		int readCount = 0;
		while (readCount < count) {
			readCount += in.read(bytes, readCount, count - readCount);
		}
		return bytes;
	}
}
