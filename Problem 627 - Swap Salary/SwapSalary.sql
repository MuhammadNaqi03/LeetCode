UPDATE salary
SET sex = CASE sex
          WHEN 'm' then 'f'
          ELSE 'm'
          END