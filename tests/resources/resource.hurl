# ============================================================
# Hurl Test - Resource API (POST only)
# Author: Juan Esteban Dulcey Gómez
# Project: Smart Scheduling
# ============================================================

# 🧪 Test: Create a new Resource
POST {{host}}/api/resources
Content-Type: application/json

{
  "siteId": "11111111-1111-1111-1111-111111111111",
  "name": "Consultorio Principal",
  "type": "Sala de Reuniones",
  "active": true
}

HTTP 201
[Asserts]
jsonpath "$.id" exists
jsonpath "$.name" == "Consultorio Principal"
jsonpath "$.type" == "Sala de Reuniones"
jsonpath "$.active" == true
