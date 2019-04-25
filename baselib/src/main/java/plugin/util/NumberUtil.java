package plugin.util;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 基本类型转换工具类
 * 作者：wjh on 2019-04-22 18:38
 */
public class NumberUtil {

    /**
     * object to double
     *
     * @param obj obj
     * @return
     */
    public static double parseDouble(Object obj) {
        double count = 0;
        if (obj != null) {
            if (obj instanceof Integer) {
                count = ((Integer) obj).doubleValue();
            } else if (obj instanceof Long) {
                count = ((Long) obj).doubleValue();
            } else if (obj instanceof BigInteger) {
                count = ((BigInteger) obj).doubleValue();
            } else if (obj instanceof Float) {
                count = ((Float) obj).doubleValue();
            } else if (obj instanceof Double) {
                count = ((Double) obj).doubleValue();
            } else if (obj instanceof BigDecimal) {
                count = ((BigDecimal) obj).doubleValue();
            } else if (obj instanceof Byte) {
                count = ((Byte) obj).doubleValue();
            } else if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return count;
                }
                try {
                    count = Double.parseDouble(((String) obj).trim());
                } catch (Exception e) {
                    return count;
                }
            }
        }

        return count;
    }

    /**
     * object to float
     *
     * @param obj obj
     * @return
     */
    public static float parseFloat(Object obj) {
        float count = 0;
        if (obj != null) {
            if (obj instanceof Integer) {
                count = ((Integer) obj).floatValue();
            } else if (obj instanceof Long) {
                count = ((Long) obj).floatValue();
            } else if (obj instanceof BigInteger) {
                count = ((BigInteger) obj).floatValue();
            } else if (obj instanceof Float) {
                count = ((Float) obj).floatValue();
            } else if (obj instanceof Double) {
                count = ((Double) obj).floatValue();
            } else if (obj instanceof BigDecimal) {
                count = ((BigDecimal) obj).floatValue();
            } else if (obj instanceof Byte) {
                count = ((Byte) obj).floatValue();
            } else if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return count;
                }
                try {
                    count = Float.parseFloat(((String) obj).trim());
                } catch (Exception e) {
                    return count;
                }
            }
        }

        return count;
    }

    /**
     * object to long
     *
     * @param obj obj
     * @return
     */
    public static long parseLong(Object obj) {
        long count = 0;
        if (obj != null) {
            if (obj instanceof Integer) {
                count = ((Integer) obj).longValue();
            } else if (obj instanceof Long) {
                count = ((Long) obj);
            } else if (obj instanceof BigInteger) {
                count = ((BigInteger) obj).longValue();
            } else if (obj instanceof Float) {
                count = (long) ((Float) obj + 0.5);
            } else if (obj instanceof Double) {
                count = (long) ((Double) obj + 0.5);
            } else if (obj instanceof BigDecimal) {
                count = ((BigDecimal) obj).longValue();
            } else if (obj instanceof Byte) {
                count = ((Byte) obj).longValue();
            } else if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return count;
                }
                try {
                    count = Long.parseLong(((String) obj).trim());
                } catch (Exception e) {
                    return count;
                }
            }
        }

        return count;
    }

    /**
     * object to int
     *
     * @param obj obj
     * @return
     */
    public static int parseInt(Object obj) {
        int count = 0;
        if (obj != null) {
            if (obj instanceof Integer) {
                count = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                try {
                    count = ((Long) obj).intValue();
                } catch (Exception e) {
                }
            } else if (obj instanceof BigInteger) {
                count = ((BigInteger) obj).intValue();
            } else if (obj instanceof Float) {
                try {
                    count = (int) ((Float) obj + 0.5);
                } catch (Exception e) {
                }
            } else if (obj instanceof Double) {
                try {
                    count = (int) ((Double) obj + 0.5);
                } catch (Exception e) {
                }
            } else if (obj instanceof BigDecimal) {
                count = ((BigDecimal) obj).intValue();
            } else if (obj instanceof Byte) {
                count = ((Byte) obj).intValue();
            } else if (obj instanceof Boolean) {
                count = ((Boolean) obj) ? 1 : 0;
            } else if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return count;
                }
                try {
                    count = Integer.parseInt(((String) obj).trim());
                } catch (Exception e) {
                    return count;
                }
            }
        }

        return count;
    }
}
