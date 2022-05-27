use case_study_module4;

select customer.customer_name customerName, c.contract_id contractId, s.service_name serviceName, c.start_day startDay,c.end_day endDay,
       group_concat(as.attach_service_name) attachService,
sum(coalesce(cd.quantity*as.attach_service_cost,0))+s.service_cost total
from customer join contract c on customer.customer_id = c.customer_id
join service s on s.service_id = c.service_id
left join contract_detail cd on c.contract_id = cd.contract_id
left join attach_service `as` on `as`.attach_service_id = cd.attach_service_id
group by c.contract_id;