use exercise;

select op.order_id, product.product_name, product.price,
       pt.name, op.order_date, op.quantity,
       sum(coalesce(op.quantity*product.price,0)) Total
from product join order_product op on product.product_id = op.product_id
join product_type pt on pt.id = product.product_type
group by op.order_id;

select op.order_id, product.product_name, product.price,
       pt.name, op.order_date, op.quantity,
       sum(coalesce(op.quantity*product.price,0)) Total
from product join order_product op on product.product_id = op.product_id
             join product_type pt on pt.id = product.product_type
group by op.order_id
order by Total DESC
limit 2;