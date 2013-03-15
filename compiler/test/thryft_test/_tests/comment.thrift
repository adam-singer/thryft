/* Multi-line C-style
    comment */
# Py-style comment
// C++-style comment
/* C-style comment */

struct MagentoProduct {
    optional string activation_information;
    optional i32 backorders;
    optional decimal.Decimal cost;
    optional date_time.DateTime created_at;
    required string description;
    optional set<magento_product_image.MagentoProductImage> images;
    optional bool is_in_stock;
    optional bool is_qty_decimal;
    optional bool is_recurring;
    optional date.Date low_stock_date;
    optional decimal.Decimal max_sale_qty;
    optional string meta_description;
    optional string meta_keyword;
    optional string meta_title;
    optional decimal.Decimal minimal_price;
    optional decimal.Decimal min_qty;
    optional decimal.Decimal min_sale_qty;
    optional string model;
    required string name;
    optional date.Date news_from_date;
    optional date.Date news_to_date;
    optional decimal.Decimal notify_stock_qty;
    // Optional in 1.3
    optional decimal.Decimal price;
    optional decimal.Decimal qty;
    optional string shipping_policy;
    required string short_description;
    required string sku;
    optional date.Date special_from_date;
    optional decimal.Decimal special_price;
    optional date.Date special_to_date;
    // Optional in 1.3
    optional magento_product_status.MagentoProductStatus status;
    optional set<string> tags;
    // Optional in 1.3
    optional magento_product_type.MagentoProductType type;
    optional date_time.DateTime updated_at;
    required string url_key;
    // Optional in 1.3
    optional string url_path;
    // Formerly an enum; the strings differ between Magento versions
    required set<string> visibility;
    optional decimal.Decimal weight;
}
